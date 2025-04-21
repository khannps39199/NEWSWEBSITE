Create database NEWSWEBSITE;

use NEWSWEBSITE;

create table users( 
	userId int primary key identity,
	userName nvarchar(50) not null unique,
	email nvarchar(250) not null unique,
	password nvarchar(50) not null ,
	isVeritify bit default(1)
)
alter table users add isAdmin bit;

go
create table posts(
	postId int primary key identity,
	userId int not null,
	title nvarchar(250) not null ,
	createAt date not null,
	picturesSrc nvarchar(250) not null,
	content nvarchar(250) not null,
	viewPost int default(0),
	likeCount int default(0),
	shareCount int default(0),
	FOREIGN KEY (userID) REFERENCES users(userId)
)

go
alter table posts add constraint FK_user_post FOREIGN KEY (userID) REFERENCES users(userId);
go

create table comments(
	cmtId int primary key identity,
	userId int not null,
	postId int not null,
	comment nvarchar(250)
)

go
alter table comments add constraint FK_user_comments FOREIGN KEY (userID) REFERENCES users(userId);
alter table comments add constraint FK_comments_post FOREIGN KEY (postID) REFERENCES posts(postId);
go

go
create table likes(
	likeId int primary key identity,
	userId int not null,
	postId int not null,
	likeAt date default(getDate())
)

go
alter table likes add constraint FK_user_likes FOREIGN KEY (userID) REFERENCES users(userId);
alter table likes add constraint FK_likes_post FOREIGN KEY (postID) REFERENCES posts(postId);
go
create table shares(
	shareId int primary key identity,
	userId int not null,
	postId int not null,
	likeAt date default(getDate())
)

go
alter table shares add constraint FK_user_shares FOREIGN KEY (userID) REFERENCES users(userId);
alter table shares add constraint FK_shares_post FOREIGN KEY (postID) REFERENCES posts(postId);
go

CREATE TRIGGER trg_IncreaseLikeCount
ON likes
AFTER INSERT
AS
BEGIN
    UPDATE posts
    SET likeCount = likeCount + 1
    FROM posts
    INNER JOIN inserted i ON posts.postId = i.postId;
END;
GO
CREATE TRIGGER trg_IncreaseShareCount
ON shares
AFTER INSERT
AS
BEGIN
    UPDATE posts
    SET shareCount = shareCount + 1
    FROM posts
    INNER JOIN inserted i ON posts.postId = i.postId;
END;
GO
