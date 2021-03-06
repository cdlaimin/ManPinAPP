
package com.mp.android.apps.book.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 获取图书详情页面
 */
public class SearchBookBean implements Parcelable {
    /**
     * 图书url详情页地址
     */
    private String noteUrl;
    /**
     * 图书缩略图
     */
    private String coverUrl;

    /**
     * 图书名称
     */
    private String name;

    /**
     * 图书作者
     */
    private String author;

    private long words;

    private String state;
    /**
     * 最新章节
     */
    private String lastChapter;

    private Boolean isAdd = false;

    private String tag;

    private String kind;

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * 来源
     */
    private String origin;

    private String desc;
    /**
     * 更新时间
     */
    private String updated;

    public SearchBookBean() {

    }

    protected SearchBookBean(Parcel in) {
        noteUrl = in.readString();
        coverUrl = in.readString();
        name = in.readString();
        author = in.readString();
        words = in.readLong();
        state = in.readString();
        lastChapter = in.readString();
        isAdd = in.readByte() != 0;
        tag = in.readString();
        kind = in.readString();
        origin = in.readString();
        desc = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteUrl);
        dest.writeString(coverUrl);
        dest.writeString(name);
        dest.writeString(author);
        dest.writeLong(words);
        dest.writeString(state);
        dest.writeString(lastChapter);
        dest.writeByte((byte) (isAdd ? 1 : 0));
        dest.writeString(tag);
        dest.writeString(kind);
        dest.writeString(origin);
        dest.writeString(desc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SearchBookBean> CREATOR = new Creator<SearchBookBean>() {
        @Override
        public SearchBookBean createFromParcel(Parcel in) {
            return new SearchBookBean(in);
        }

        @Override
        public SearchBookBean[] newArray(int size) {
            return new SearchBookBean[size];
        }
    };

    public String getNoteUrl() {
        return noteUrl;
    }

    public void setNoteUrl(String noteUrl) {
        this.noteUrl = noteUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getAdd() {
        return isAdd;
    }

    public void setAdd(Boolean add) {
        isAdd = add;
    }

    public long getWords() {
        return words;
    }

    public void setWords(long words) {
        this.words = words;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLastChapter() {
        return lastChapter == null ? "" : lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}