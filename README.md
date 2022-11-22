# Safaricom Express(USSD Push)
Express initiates online payment on behalf of the customer using USSD Push. 

## 1. Authentication

#### 1.1 Register for a Safaricom Developer Account
For authentication credentials to be used only for the sandbox, Safaricom Developer Account is required. To log in or register, go to https://developer.safaricom.co.ke/. The Organization Information must be provided when applying for new credentials when going live.

#### 1.2 Create an app
Using https://developer.safaricom.co.ke/MyApps, you can create an app and select the Lipa Na M-Pesa and M-Pesa Sandbox check boxes. By creating an app, you can obtain the Consumer Key and Consumer Secret that will be used for Basic Authentication.

### Step 1: Get Access Token using Basic Auth
| METHOD | GET                                                                                      |
|--------|------------------------------------------------------------------------------------------|
| URL    | Sandbox: https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials |

##### Successful Request

```yaml
curl --location --request GET 'http://localhost:8080/accessToken'
```
##### Request Fields
| NAME          | DESCRIPTION                                                                                                     | TYPE   |
|---------------|-----------------------------------------------------------------------------------------------------------------|--------|
| authorization | Basic Authentication over HTTPS, this is a base64 encoded string of your app’s consumer key and consumer secret | Header |
| grant_type    | client _credentials grant type is supported. Put this under params                                              | Query  |

#### Successful Response
```yaml
{
    "access_token": "ZPRHAAXD1oaZ1gp9EdXFGVfw8Gv6",
    "expires_in": "3599"
}
```

##### Response Fields
| NAME         | DESCRIPTION                                                       | TYPE |
|--------------|-------------------------------------------------------------------|------|
| access_token | Access token used to access the customer to business payments api | JSON |
| expires_in   | Token expiry time in seconds                                      | JSON |

### Step 2: Initiate an express(USSD Push) payment
| METHOD | POST                                                                     |
|--------|--------------------------------------------------------------------------|
| URL    | Sandbox: https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest |

##### Successful Request

```yaml
curl --location --request POST 'http://localhost:8080/stkPush' \
--header 'Content-Type: application/json' \
  --data-raw '{
"Amount": 1,
"PhoneNumber": 2547484581XX
}'
```
##### Request Fields
| NAME        | DESCRIPTION                                      | TYPE    |
|-------------|--------------------------------------------------|---------|
| Amount      | The amount transacted normally integer value     | Integer |
| PhoneNumber | The Mobile Number to receive the USSD Pin Prompt | Integer |

#### Successful Response
```yaml
{
  "MerchantRequestID": "68444-143235050-2",
  "CheckoutRequestID": "ws_CO_22112022152650652748458100",
  "ResponseCode": "0",
  "ResponseDescription": "Success. Request accepted for processing",
  "CustomerMessage": "Success. Request accepted for processing"
}
```

##### Response Fields
| NAME                | DESCRIPTION                                                                                                                                                           | TYPE    |
|---------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------|
| MerchantRequestID   | This is a globally unique identifier for any submitted payment request                                                                                                | String  |
| CheckoutRequestID   | This is a globally unique identifier of the processed checkout transaction request                                                                                    | String  |
| ResponseDescription | An acknowledgement message from API that gives the status of the request submission usually maps to a specific ResponseCode value                                     | Numeric |
| ResponseCode        | This is a Numeric status code that indicates the status of the transaction submission. 0 means successful submission and any other means code means an error occurred | Numeric |
| CustomerMessage     | This is a message that your system can display to the Customer as an acknowledgment of the payment request submission                                                 | String  |

#### Data sent to the Callback URL
```yaml
{
  "Body": {
    "stkCallback": {
      "MerchantRequestID": "68444-143235050-2",
      "CheckoutRequestID": "ws_CO_22112022152650652748458100",
      "ResultCode": 0,
      "ResultDesc": "The service request is processed successfully.",
      "CallbackMetadata": {
        "Item": [
          {
            "Name": "Amount",
            "Value": 1
          },
          {
            "Name": "MpesaReceiptNumber",
            "Value": "QKM0FXE6RK"
          },
          {
            "Name": "TransactionDate",
            "Value": 20221122152706
          },
          {
            "Name": "PhoneNumber",
            "Value": 2547484581XX
          }
        ]
      }
    }
  }
}
```
#### Error Codes
| ERROR CODE   | DESCRIPTION                    |
|--------------|--------------------------------|
| 404.001.03   | Invalid access token           |
| 500.001.1001 | Transaction already in process |