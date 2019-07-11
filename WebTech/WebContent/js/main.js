var rootURL = "http://localhost:8080/WebTech/list/books";

$(document).ready(function(){
	findAll();
//	$('#btnDelete').hide();
});

//$(document).on("click", "#bookList a", function(){findById(this.id);});
//
//var currentBook;
//
//var findById=function(id){
//	console.log('findById '+ id);
//	$.ajax({
//			type: 'GET',
//			url: rootURL + '/' + id,
//			dataType: "json",
//			success: function(data){
//				$('#btnDelete').show();
//				console.log('findById success: ' + data.name);
//				currentBook = data;
//				renderDetails(currentBook);
//			}
//	});
//};
//
//
//var checkFields = function(){
//
//	if($('#bookId').val() == '')
//		addBook();
//	else
//		updateBook();
//	return false;
//};
//
//var search = function() {
//	if($('#search').val() == '')
//		findAll();
//	else
//		findByName('#search')
//};

//function findByName($('#name').val()){
//	$query = "SELECT * FROM wine WHERE UPPER(name) LIKE ". '"%'.$name.'%"'." ORDER BY name";
//		try{
//			global $db;
//			$wines = $db->query($query);
//			$wine = $wines->fetchAll(PDO::FETCH_ASSOC);
//			header("Content-Type: application/json", true);
//			
//			echo'{"wine": ' . json_encode($wine) . '}';
//		}catch(PDOException $e) {
//			echo '{"error":{"text":'.$e->getMessage() . '}}';
//		}
//}
//
//var updateBook= function() {
//	console.log('updateBook');
//	$.ajax({
//		type: 'PUT',
//		contentType: 'application/json',
//		url: rootURL + '/' + $('#bookId').val(),
//		dataType: "json",
//		data: formToJSONUpdate(),
//		success: function(data, textStatus, jqXHR){
//			alert('book updated successfully');
//		},
//		error: function(jqXHR, textStatus, errorThrown){
//			alert('updatebook error ' + textStauts);
//		}
//	});
//};


var findAll=function(){
	console.log('findAll');
	$.ajax({
			type: 'GET',
			url: rootURL,
			dataType: "json",
			success: renderList
	});
};

//function renderList(data) {
//
//	$.each(data, function(index, book){
//		$('#bookList').append('<li><a href="#" id="' + book.id + '">' + book.name + '</a></li>');
//	});
//}

var renderList = function(data) {
//	list=data.book
//	console.log("response");
	$.each(data, function(index, book){
		$('#table_body').append('<tr><td>' + book.year + '</td><td>'+
				book.name+'</td><td>'+book.author+'</td><td>'+book.pages+'</td></tr>');
	});
	$('#table_id').DataTable();
	output='<div class="row>"';
	
	$.each(data, function(index, book){
		var img="pictures/"+book.picture;
		output+=('<div class="col-sm-6 col-md-4 col-lg-3"><div class="card"><img src='+'"'+
				'height="150"><p>name: '+book.year+'</p><p>Country: '+book.name+'</p><p>Region: '+book.author+'</p></div></div>');
	});
	output += '</div>';
	$('#productList').append(output);
};


//var newBook=function(){
//	console.log('clearAll');
//	$('#bookId').val(null);
//	$('#year').val(null);
//	$('#name').val(null);
//	$('#author').val(null);
//	$('#pages').val(null);
//	$('#theme').val(null);
//	$('#price').val(null);
//	$('#rating').val(null);
//	
//};
//
//var formToJSON=function () {
//	
//	return JSON.stringify({
//	
//	"year":	$('#year').val(),
//	"name": $('#name').val(),
//	"author": $('#author').val(),
//	"pages": $('#pages').val(),
//	"theme":	$('#theme').val(),
//	"price": $('#price').val(),
//	"rating": $('#rating').val()
//	});
//};
//
//var formToJSONUpdate=function () {
//	
//	return JSON.stringify({
//	"id": $('#bookId').val(),
//	"year":	$('#year').val(),
//	"name": $('#name').val(),
//	"author": $('#author').val(),
//	"pages": $('#pages').val(),
//	"theme":	$('#theme').val(),
//	"price": $('#price').val(),
//	"rating": $('#rating').val()
//	});
//};
//
//var addBook = function () {
//	console.log('addBook');
//	$.ajax({
//		type: 'POST',
//		contentType: 'application/json',
//		url: rootURL,
//		dataType: "json",
//		data: formToJSON(),
//		success: function(data, textStatus, jqXHR){
//			alert('Book created successfully');
//			$('#bookId').val(data.id);
//			findAll();
//		},
//		error: function(jqXHR, textStatus, errorThrown){
//			alert('addBook error: ' + textStatus);
//		}
//	});
//	
//};
//
//var deleteBook =function() {
//	console.log('deleteBook');
//	$.ajax({
//		type: 'DELETE',
//		url: rootURL + '/' + $('#bookId').val(),
//		success: function(data, textStatus, jqXHR){
//			alert('Book deleted successfully');
//		},
//		error: function(jqXHR, textStatus, errorThrown){
//			alert('deleteBook error');
//		}
//			
//	});
//	location.reload();
//};
//var renderDetails = function(book) {
//		$('#bookId').val(book.id);
//		$('#year').val(book.year);
//		$('#name').val(book.name);
//		$('#author').val(book.author);
//		$('#pages').val(book.pages);
//		$('#theme').val(book.theme);
//		$('#price').val(book.price);
//		$('#rating').val(book.rating);
//		
//};
//
//$(document).ready(function(){
//	findAll();
//});
//
//var findAll=function() {
//	console.log('findAll');
//	$.ajax({
//		type: 'GET',
//		url: "http://localhost:8080/WebTech/list/books",
//		data : {Book},
//		dataType: "json",
//		success: renderList
//			
//	});
//};
//
//function renderList(books) {
//	 list=data.books;
//	$('#bookList li').remove();
//	$.each(list, function(index, books) {
//		$('#bookList').append('<li><a href="#" id="' + books.id + '">'+ books.name+'</a></li>');
//	});
//}