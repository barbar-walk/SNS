// WebAPIを呼び出す関数
function callWebAPI() {
    var button = document.getElementById('btn-more');
    var maxId = button.getAttribute('data-maxid');

    // WebAPIのエンドポイントやリクエストを記述
    fetch('http://localhost:8082/api/post/getPosts?maxId=' + maxId)
        .then(response => response.json())
        .then(ret => {
            // WebAPIからのレスポンスを処理
            console.log(ret);

            for (let post of ret.data) {
                // テンプレート要素を取得する
                var templateElement = document.getElementById('template');
                // テンプレートから新しい要素を複製してDOMに追加する
                var clonedTemplate = templateElement.cloneNode(true);
                // クローンのコメントエリアは削除
                var commentTemplateElement = clonedTemplate.querySelector('#comment-template');
                commentTemplateElement.parentNode.removeChild(commentTemplateElement);

                clonedTemplate.style.display = 'block';

                // データのセットを行う。
                clonedTemplate.querySelector('#posts-users-iconuri').src = (post.users.iconUri == null) ? '/assets/img/profile-dummy.png' : post.users.iconUri;
                clonedTemplate.querySelector('#user-name').textContent = post.users.name;
                clonedTemplate.querySelector('#title').textContent = post.title;
                clonedTemplate.querySelector('#body').innerHTML = post.body.replace(/\n/g, '<br>');
                clonedTemplate.querySelector('#comment-form').action = '/comment/' + post.id;

                var isNotImageExist = true;
                for (let postImage of post.postImagesList) {
                    clonedTemplate.querySelector('#postimage-imageuri').src = postImage.imageUri;
                    isNotImageExist = false;
                }
                if (isNotImageExist) {
                    clonedTemplate.querySelector('#postimage-imageuri').remove();
                }

                // コメントがあったら
                if (post.postCommentsList != null) {
                    // テンプレート要素を取得し、クローンを作成。
                    var commentTemplateElement = document.getElementById('comment-template');
                    var clonedCommentTemplate = commentTemplateElement.cloneNode(true);
                    var removeCommentItem = clonedCommentTemplate.querySelector('#comment-item');
                    removeCommentItem.parentNode.removeChild(removeCommentItem);

                    for (let postComment of post.postCommentsList) {
                        var commentItemElement = document.getElementById('comment-item');
                        var clonedCommentItem = commentItemElement.cloneNode(true);

                        clonedCommentItem.querySelector('#comment-users-iconuri').src = (postComment.users.iconUri == null) ? '/assets/img/profile-dummy.png' : postComment.users.iconUri;
                        clonedCommentItem.querySelector('#comment-users-name').textContent = postComment.users.name;
                        clonedCommentItem.querySelector('#comment').textContent = postComment.comment;

                        clonedCommentTemplate.querySelector('#news').appendChild(clonedCommentItem);
                    }

                    clonedTemplate.appendChild(clonedCommentTemplate);
                }

                document.getElementById('container').appendChild(clonedTemplate);
            }

        })
        .catch(error => {
            // エラーハンドリング
            console.error('Error fetching data:', error);
        });
}

