package com.cmloopy.comic.models

import java.sql.Timestamp

class Comic (var idComic: Int, var nameComic: String,
             var content: String, var view: Int,
             var imageUrl: String, var urlComic: String,
             //test
             var img: Int,
             var likes: Int, var sc: Int,
             //var createdAt: Timestamp,
             //var updatedAt: Timestamp,
             var nameAuthor: String,
             var idUser: Int,
             var idNewChapter: Int,
             var newChapter: String) {

}