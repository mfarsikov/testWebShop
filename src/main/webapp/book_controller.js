/**
 * Created by Kot on 12.12.15.
 */
'use strict';

App.controller('BookController',['$scope', 'BookService', function($scope, BookService){
    var self = this;
    self.book = {id:null, title:'', author:''};
    self.books = {};

    self.getAllBooks = function(){
        BookService.getAllBooks().
            then(       function(b){
                            self.books = b;
                        },
                        function(errResponse){
                            console.error('Error while getting books');
                });
    };

    self.getAllBooks();

    self.addBook = function(book){
        BookService.createBook(book).then(self.getAllBooks(), function(errResponse){
            console.error('error while creating book');
        });
    };

    self.submit = function() {
        console.log(self.book.id);
        if(self.book.id != null){
            console.log('Saving New Book', self.book);
            self.addBook(self.book);
        }else{

            console.log('hueta');
        }
        self.reset();
    };

    self.reset = function(){
        self.book={id:null,title:'',author:''};
        $scope.myForm.$setPristine(); //reset Form
    };


}]);