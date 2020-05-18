

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

eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTg5Nzc3MjU4LCJleHAiOjE1OTAzODIwNTh9.qmAY3TOgxHYdFl5_EfhEU7N6IbvmpxYpZtSyyI57kmDOOu3vU8HYbCRezx_oIYPrv74vbsT-aYWeInj_10S9qA


Authorization: Bearer <accessToken>


	mvn spring-boot:run