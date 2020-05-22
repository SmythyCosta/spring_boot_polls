
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
