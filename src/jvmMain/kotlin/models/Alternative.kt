package models

data class Alternative(
    var name:String,
    var type:TypeMinMax
){

}
enum class TypeMinMax(
    name:String
){
    MIN(
        name = "MIN"
    ),
    MAX(
        name="MAX"
    )
}