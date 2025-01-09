run:
	uvicorn main:app --reload

env:
	penv fastapi-env

get_item:
	curl -X GET http://localhost:8000/get-item/1/Milk

get_by_name:
	curl -X GET http://localhost:8000/get-by-name\?name\=Milk
