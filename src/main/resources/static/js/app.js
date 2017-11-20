var removeTagButton = document.getElementById('remove-tag-button');
removeTagButton.addEventListener('click', function() {
	if (confirm('Are you sure you want to remove this tag?')) {
		removeTagButton.setAttribute('th:formaction',
		'@{/remove-cancelled(id=${review.id})}');
	}
});


var links = document.querySelectorAll('div a');

for (var i = 0; i < links.length; i++) {
	links[i].addEventListener('mouseover', function() {
		this.style.fontSize = '40px';
	});
	links[i].addEventListener('mouseout', function() {
		this.style.fontSize = '30px';
	});
}

var copyrightText = document.querySelector('footer p');

copyrightText.addEventListener('mouseover', function() {
	this.innerText = 'Made by Sarah Strange';
});
copyrightText.addEventListener('mouseout', function() {
	this.innerText = 'Copyright 2017';
});

var submitComment = document.getElementById('submit-comment');
var commentNum = 0;

submitComment
		.addEventListener(
				'click',
				function() {
					commentNum = commentNum + 1;
					var commentContent = document
							.getElementById('comment-content').value, commentSection = document
							.getElementById('comment-section'), commentDiv = document
							.createElement('div');
					commentDiv.id = "commentNum" + commentNum;
					commentDiv.innerHTML = commentContent;
					commentDiv.style.border = '1px solid black';
					var deleteCommentButton = document.createElement('button');
					deleteCommentButton.id = 'commentNum' + commentNum;
					deleteCommentButton.innerText = 'X';
					deleteCommentButton
							.addEventListener(
									'click',
									function() {
										if (confirm("Are you sure you want to delete that comment?")) {
											var removeComment = document
													.getElementById(this.id);
											removeComment.parentNode
													.removeChild(removeComment);
										}
									})
					commentDiv.appendChild(deleteCommentButton);
					commentSection.appendChild(commentDiv);
					commentDiv.appendChild(commentContent);
				});

