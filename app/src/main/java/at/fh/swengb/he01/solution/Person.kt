package at.fh.swengb.he01.solution

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Person (val name: String, val profileImagePath: String){
}