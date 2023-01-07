package com.gorani.projectsmilehair.model

import com.google.gson.annotations.SerializedName

data class Title(
    val text: String,
    @SerializedName("icon_url") val iconUrl: String?
)
// detail 데이터에서 Title 클래스의 text 멤버 변수를 사용할 것이기 때문에 본 클래스는 재사용 가능
// detail 에서는 text 변수만 사용되기 때문에 iconUrl 변수는 nullable 로 변경해야할 것 같음.