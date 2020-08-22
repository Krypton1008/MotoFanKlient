package pl.krypot.motofanmobile.data.event

data class Event (val id: Long,
                    val name: String,
                    val eventType: String,
                    val beginDate: String,
                    val place: String,
                    val description:String)