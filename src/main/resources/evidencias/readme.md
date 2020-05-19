

POST   http://localhost:5000/api/auth/signup

{
	"name":"Smythy Costa",
	"username":"smythy.costa",
	"email":"smythy.costa@gmail.com",
	"password":"123456"
}



POST   http://localhost:5000/api/auth/signin

{
	"usernameOrEmail":"smythy.costa",
	"password":"123456"
}

eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTg5ODE0MTUyLCJleHAiOjE1OTA0MTg5NTJ9.vKYKp7APZTCjIdRHhgApI3dl_jhmvp9_gQfLYZzAWd_7z1lExBm50ISMRfv5w83PX3SylpCDOJsvCboEa47Mqg


Authorization: Bearer <accessToken>


	mvn spring-boot:run





POST   http://localhost:5000/api/auth/signup

{
"question": "melho time do brasil",
"choices": [
    {
        "text": "flamengo"
    },
    {
        "text": "palmeiras"
    }
],
"pollLength":
	    {
        "days": 21,
        "hours": 12
    	}
}


2020-05-18 11:32:15
2020-05-25 11:32:15

