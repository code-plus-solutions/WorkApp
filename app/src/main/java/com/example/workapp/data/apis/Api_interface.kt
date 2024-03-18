import com.example.workapp.data.models.Model_Register
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api_interface {

    @POST("/api/register")
    suspend fun Register_worker(@Body requestBody: RequestBody): Response<Model_Register>


}
