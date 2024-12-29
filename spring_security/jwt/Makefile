PORT ?= 6969
ENDPOINT ?= http://localhost:${PORT}
USERNAME ?= shres
PASSWORD ?= s@123

run:
	mvn spring-boot:run

get_home:
	curl -X GET ${ENDPOINT} --user ${USERNAME}:${PASSWORD}

get_students:
	curl -X GET ${ENDPOINT}/students --user ${USERNAME}:${PASSWORD} | jq

get_csrf:
	curl -X GET ${ENDPOINT}/csrf-token --user ${USERNAME}:${PASSWORD} | jq

post_students:
	curl -X POST ${ENDPOINT}/students \
	--user ${USERNAME}:${PASSWORD} \
	-H "Content-Type: application/json" \
	-d '{"id": 3, "name": "John Cena", "marks": 89}' | jq





REGISTER_ID ?= 5
REGISTER_USER ?= SpringUser
REGISTER_PASSWORD ?= p@123

post_register:
	curl -X POST ${ENDPOINT}/register \
	-H "Content-Type: application/json" \
	-d '{"id": ${REGISTER_ID}, "username": "${REGISTER_USER}", "password": "${REGISTER_PASSWORD}"}' | jq
	
post_login:
	curl -X POST ${ENDPOINT}/login \
	-H "Content-Type: application/json" \
	-d '{"id": ${REGISTER_ID}, "username": "${REGISTER_USER}", "password": "${REGISTER_PASSWORD}"}'
