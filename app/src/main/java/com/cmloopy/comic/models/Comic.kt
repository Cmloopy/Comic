import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class Comic(
    @SerializedName("idComic") val idComic: Int,
    @SerializedName("nameComic") val nameComic: String,
    @SerializedName("content") val content: String,
    @SerializedName("view") val view: Int,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("urlComic") val urlComic: String,
    @SerializedName("likes") val likes: Int,
    @SerializedName("sc") val sc: Int,
    @SerializedName("status") val status: Int,
    @SerializedName("createdAt") val createdAt: Timestamp,
    @SerializedName("updatedAt") val updatedAt: Timestamp,
    @SerializedName("idAuthor") val idAuthor: Int,
    @SerializedName("nameAuthor") val nameAuthor: String,
    @SerializedName("idUser") val idUser: Int,
    @SerializedName("idChapter") val idChapter: Int,
    @SerializedName("nameChapter") val nameChapter: String
)