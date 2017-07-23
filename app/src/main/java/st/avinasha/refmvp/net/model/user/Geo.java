package st.avinasha.refmvp.net.model.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public final class Geo implements Parcelable {

    @SerializedName("lat") private final String latitude;
    @SerializedName("lng") private final String longitude;

    public Geo(@Nullable String latitude, @Nullable String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // region Getter methods.
    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
    // endregion Getter methods.

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Geo geo = (Geo) o;

        if (getLatitude() != null ? !getLatitude().equals(geo.getLatitude())
                : geo.getLatitude() != null) {
            return false;
        }
        return getLongitude() != null ? getLongitude().equals(geo.getLongitude())
                : geo.getLongitude() == null;
    }

    @Override
    public int hashCode() {
        int result = getLatitude() != null ? getLatitude().hashCode() : 0;
        result = 31 * result + (getLongitude() != null ? getLongitude().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    // region Parcelable
    protected Geo(Parcel in) {
        this.latitude = in.readString();
        this.longitude = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(latitude);
        dest.writeString(longitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Geo> CREATOR = new Creator<Geo>() {
        @Override
        public Geo createFromParcel(Parcel in) {
            return new Geo(in);
        }

        @Override
        public Geo[] newArray(int size) {
            return new Geo[size];
        }
    };
    // endregion Parcelable
}
