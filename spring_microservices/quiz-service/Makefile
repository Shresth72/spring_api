run:
	mvn spring-boot:run

# QUESTION
all_questions:
	curl -X GET http://localhost:8001/question/allQuestions | jq

# GET
GET_CATEGORY ?= geography

questions_by_category:
	curl -X GET http://localhost:8001/question/category/${CATEGORY} | jq

# QUIZ
CATEGORY ?= Geography
NUM_QUESTIONS ?= 5

create_quiz:
	curl -X GET http://localhost:8001/quiz/create -H "Content-Type: application/json" -d '{"categoryName": "${CATEGORY}", "numQuestions": 5, "title": "Geo Test 2"}'

quiz_by_id:
	curl -X GET http://localhost:8001/quiz/get/1 | jq

submit_quiz:
	curl -X POST http://localhost:8001/quiz/submit/1 \
	-H "Content-Type: application/json" \
	-d '[{ "questionId": 1, "selectedAnswer": "Paris" }, { "questionId": 2, "selectedAnswer": "4" }, { "questionId": 3, "selectedAnswer": "Newton" }]'






















add_question:
	curl -X POST http://localhost:8001/question/add \
	-H "Content-Type: application/json" \
	-d '{"questionTitle": "Where is India located?", "option1": "Asia", "option2": "Africa", "option3": "North America", "option4": "Europe", "rightAnswer": "Asia", "difficultylevel": "Easy", "category": "Geography"}'

add_question_1:
	curl -X POST http://localhost:8001/question/add \
	-H "Content-Type: application/json" \
	-d '{"questionTitle": "What is the largest continent?", "option1": "Africa", "option2": "Asia", "option3": "Europe", "option4": "Antarctica", "rightAnswer": "Asia", "difficultylevel": "Easy", "category": "Geography"}'

add_question_2:
	curl -X POST http://localhost:8001/question/add \
	-H "Content-Type: application/json" \
	-d '{"questionTitle": "Which ocean is the largest?", "option1": "Atlantic Ocean", "option2": "Indian Ocean", "option3": "Pacific Ocean", "option4": "Arctic Ocean", "rightAnswer": "Pacific Ocean", "difficultylevel": "Medium", "category": "Geography"}'

add_question_3:
	curl -X POST http://localhost:8001/question/add \
	-H "Content-Type: application/json" \
	-d '{"questionTitle": "What is the capital of Australia?", "option1": "Sydney", "option2": "Melbourne", "option3": "Canberra", "option4": "Brisbane", "rightAnswer": "Canberra", "difficultylevel": "Easy", "category": "Geography"}'

add_question_4:
	curl -X POST http://localhost:8001/question/add \
	-H "Content-Type: application/json" \
	-d '{"questionTitle": "Which country has the highest population?", "option1": "India", "option2": "China", "option3": "United States", "option4": "Russia", "rightAnswer": "China", "difficultylevel": "Easy", "category": "Geography"}'

add_question_5:
	curl -X POST http://localhost:8001/question/add \
	-H "Content-Type: application/json" \
	-d '{"questionTitle": "Through which continent does the Nile River flow?", "option1": "Asia", "option2": "Africa", "option3": "Europe", "option4": "South America", "rightAnswer": "Africa", "difficultylevel": "Medium", "category": "Geography"}'

add_question_6:
	curl -X POST http://localhost:8001/question/add \
	-H "Content-Type: application/json" \
	-d '{"questionTitle": "What is the smallest country in the world?", "option1": "Vatican City", "option2": "Monaco", "option3": "San Marino", "option4": "Liechtenstein", "rightAnswer": "Vatican City", "difficultylevel": "Hard", "category": "Geography"}'



