# HomeLibrary
Microservice to maintain a home library

Get endpoints
/books - To get all books
/books/available - To get all books available in the library
/books/{id} - To get a book by book's id
/slot - To get the available slot for adding a book

Post endpoints
/books - To add a new book
Post request body - json
mandatory fields - name and language
example : {
	"name": "Test_1",
	"language": "English"
}

Put endpoints
/books/take/{id} - To take the book and make the slot available for other books

TO DO : Filter by language and Search by name(Full text and partial)

