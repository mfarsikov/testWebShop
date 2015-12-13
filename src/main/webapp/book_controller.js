/**
 * Created by Kot on 12.12.15.
 */
'use strict';

App.controller('BookController', ['$scope', 'BookService', function ($scope, BookService) {
    var bookController = this;
    bookController.book = {id: null, title: '', author: ''};
    bookController.books = {};

    bookController.getAllBooks = function () {
        BookService.getAllBooks()
            .then(function (books) {
                    bookController.books = books;
                },
                function (errResponse) {
                    console.error('Error while getting books: ' + JSON.stringify(errResponse));
                });
    };

    bookController.getAllBooks();

    bookController.addBook = function (book) {
        BookService.createBook(book)
            .then(bookController.getAllBooks,
                function (errResponse) {
                    console.error('error while creating book: ' + JSON.stringify(errResponse));
                });
    };

    bookController.submit = function () {
        console.log('Saving New Book', bookController.book);
        bookController.addBook(bookController.book);
        bookController.reset();
    };

    bookController.reset = function () {
        bookController.book = {id: null, title: '', author: ''};
        $scope.myForm.$setPristine(); //reset Form
    };
}]);