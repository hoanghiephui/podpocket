package com.furkanaskin.app.podpocket.service.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class RecommendationsItem(

        @field:SerializedName("image")
        val image: String? = null,

        @field:SerializedName("thumbnail")
        val thumbnail: String? = null,

        @field:SerializedName("explicit_content")
        val explicitContent: Boolean? = null,

        @field:SerializedName("listennotes_edit_url")
        val listennotesEditUrl: String? = null,

        @field:SerializedName("description")
        val description: String? = null,

        @field:SerializedName("podcast_id")
        val podcastId: String? = null,

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("listennotes_url")
        val listennotesUrl: String? = null,

        @field:SerializedName("podcast_title")
        val podcastTitle: String? = null,

        @field:SerializedName("audio_length_sec")
        val audioLength: Int? = null,

        @field:SerializedName("publisher")
        val publisher: String? = null,

        @field:SerializedName("audio")
        val audio: String? = null,

        @field:SerializedName("id")
        val id: String? = null,

        @field:SerializedName("pub_date_ms")
        val pubDateMs: Long? = null,

        @field:SerializedName("maybe_audio_invalid")
        val maybeAudioInvalid: Boolean? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readValue(Long::class.java.classLoader) as? Long,
            parcel.readValue(Boolean::class.java.classLoader) as? Boolean)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(image)
        parcel.writeString(thumbnail)
        parcel.writeValue(explicitContent)
        parcel.writeString(listennotesEditUrl)
        parcel.writeString(description)
        parcel.writeString(podcastId)
        parcel.writeString(title)
        parcel.writeString(listennotesUrl)
        parcel.writeString(podcastTitle)
        parcel.writeValue(audioLength)
        parcel.writeString(publisher)
        parcel.writeString(audio)
        parcel.writeString(id)
        parcel.writeValue(pubDateMs)
        parcel.writeValue(maybeAudioInvalid)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RecommendationsItem> {
        override fun createFromParcel(parcel: Parcel): RecommendationsItem {
            return RecommendationsItem(parcel)
        }

        override fun newArray(size: Int): Array<RecommendationsItem?> {
            return arrayOfNulls(size)
        }
    }
}