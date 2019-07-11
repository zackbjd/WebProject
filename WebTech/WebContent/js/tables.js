var rootURL = "http://localhost:8080/WebTech/list/books";

$(document).ready(function(){
	findAll();
//	$('#btnDelete').hide();
});


var findAll=function(){
	console.log('findAll');
	$.ajax({
			type: 'GET',
			url: rootURL,
			dataType: "json",
			success: renderList
	});
};

$(document).on("click", "#btnAdd", function() {
	
	   addBook();
		
	});

var formToJSON = function(){
    var id = $('#id').val();
    return JSON.stringify({
        
        "year"        : $('#year').val(),
        "name"        : $('#name').val(),
        "author"      : $('#author').val(),
        "pages"       : $('#pages').val(),
        "theme"       : $('#theme').val(),
        "price"       : $('#price').val(),
        "rating"   : $('#rating').val(),
        "picture"   : ""
    });
}

var addBook = function(){
    console.log("addBook()");
    //$('#btnDelete').hide();
    
    $.ajax(
            {
                type:   'POST',
                contentType:    'application/json',
                url:    rootURL,
                dataType:   "json",
                data:   formToJSON(),
                success:    function(data, textStatus, jqXHR){
					alert('Book added!');
					location.reload(true);
					console.log(data);
                    
                },
                error: function(jqXHR, textStatus, error){
                    console.log("Error creating book!");
                }
            });
}
function renderList (data){
	$.each(data,function(index, book){
		 var id = book.id;
		console.log(id + " book");
		 $('#table_body').append('<tr><td>'+ book.id +'</td><td>'+book.year+'</td><td>'+book.name+'</td><td>'+book.author+'</td><td>'+
				 '<button type="button" id="btnSave'+ id +'" class="btn btn-warning" BookId="' + id + '" data-toggle="modal" data-target="#bookUpdateModal">Edit</button></td></tr>');
	
		 $(document).on("click",'#btnSave'+ id, function(){
			 $.ajax({
				 type:'GET',
				 url:rootURL+'/'+id,
				 datatype:"json",
				 success: function(data){
					 $('#id').val(data.id);
					$('#updateYear').val(data.year);
					$('#updateName').val(data.name);
					$('#updateAuthor').val(data.author);
					$('#updatePages').val(data.pages);
					$('#updateTheme').val(data.theme);
					
					$('.modal').on("click",'#btnSave', function(){
						var year = $('#updateYear').val();
						var name = $('#updateName').val();
						var author = $('#updateAuthor').val();
						var pages = $('#updatePages').val();
						var theme = $('#updateTheme').val();
						
							$.ajax({
								type: 'PUT',
								contentType: 'application/json',
								url: rootURL + '/' + id,
								dataType: "json",
								
								data: formToJSONUpdate(id),
								success: function(data, textStatus, jqXHR){
									console.log(id + "here");
								
									alert('updated');
									location.reload(true);
									
								},
								error: function(jqXHR, textStatus, errorThrown){
									alert('update error: '+textStatus);
								}
							})
					});
				$('.modal').on("click",'#btnDelete', function(){
					$.ajax({
						type: 'DELETE',
						url: rootURL + '/' + id,
						success: function(data, textStatus, jqXHR){
							alert('book deleted successfully');
							location.reload(true);
						},
						error: function(jqXHR, textStatus, errorThrown){
							alert('error:' +textStatus);
						}
					
					});
				});
			
		
				},
			}
		);
	});
	});
	$.each(data, function(index, book){
//		<div class="card" style="width: 18rem;">
//		  <img class="card-img-top" src="..." alt="Card image cap">
//		  
//		    <h5 class="card-title">Card title</h5>
//		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
//		    <a href="#" class="btn btn-primary">Go somewhere</a>
//		  </div>
//		</div>
		$('.row').append('<div class="col-sm-6 col-md-4 col-lg-3">'+
					'<div class="card">' +
					'<img class = "card-img-top" src="images/' + book.picture + '" width = "200" height ="400" alt = "pic">' + 
					'<div class="card-body">'+
					'<h5 class ="card-title">  ' + book.year + ',  ' + book.name + '</h5>' +
					'<ul class = "list-group-item"><li class = "list-group-item" <span class=left>Author: </span>' + book.author + '</li>'+
						'<li class = "list-group-item"<span class=left>Theme: </span>' + book.theme + '</li>' +
						'<li class = "list-group-item"<span class=left>Pages: </span>' + book.pages + '</li>' +
						'<li class = "list-group-item"<span class=left>Price: </span>' + book.price + '</li>' +
					'</ul>' + 
				'</div>'+
			'</div>'+
			'</div>'
				);
});

$('#table_id').DataTable({
    buttons: [
        {
            extend: 'edit',
            editor: myEditor
        }
    ]
})
}
var formToJSONUpdate=function(id){
	return JSON.stringify({
		"id": id,
		"year": $('#updateYear').val(),
		"name": $('#updateName').val(),
		"author": $('#updateAuthor').val(),
		"pages": $('#updatePages').val(),
		"theme": $('#updateTheme').val()
		
		});


};
