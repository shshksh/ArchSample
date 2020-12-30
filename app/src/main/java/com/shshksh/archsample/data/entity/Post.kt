package com.shshksh.archsample.data.entity

import android.os.Parcel
import android.os.Parcelable

data class Post(
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String,
) : Parcelable {

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.apply {
            writeLong(userId)
            writeLong(id)
            writeString(title)
            writeString(body)
        }
    }

    constructor(`in`: Parcel) : this(
        `in`.readLong(),
        `in`.readLong(),
        `in`.readString() ?: "",
        `in`.readString() ?: ""
    )

    companion object {
        val CREATOR: Parcelable.Creator<Post> = object : Parcelable.Creator<Post> {
            override fun createFromParcel(source: Parcel): Post {
                return Post(source)
            }

            override fun newArray(size: Int): Array<Post?> {
                return arrayOfNulls(size)
            }
        }
    }
}