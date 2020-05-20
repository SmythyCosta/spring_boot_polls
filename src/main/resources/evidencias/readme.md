
# run app
	mvn spring-boot:run

# signup
POST   http://localhost:5000/api/auth/signup

{
	"name":"Smythy Costa",
	"username":"smythy.costa",
	"email":"smythy.costa@gmail.com",
	"password":"123456"
}


# signin
POST   http://localhost:5000/api/auth/signin

{
	"usernameOrEmail":"smythy.costa",
	"password":"123456"
}

# Authorization
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTg5ODE0MTUyLCJleHAiOjE1OTA0MTg5NTJ9.vKYKp7APZTCjIdRHhgApI3dl_jhmvp9_gQfLYZzAWd_7z1lExBm50ISMRfv5w83PX3SylpCDOJsvCboEa47Mqg

Authorization: Bearer <accessToken>


# add polls

GET   http://localhost:5000/api/polls
GET   http://localhost:5000/api/polls/pollId

POST   http://localhost:5000/api/polls

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

POST  http://localhost:5000/api/polls/1/votes

	{
	"choiceId": 1
	}



# exemple mysql timestamp
2020-05-18 11:32:15
2020-05-25 11:32:15

