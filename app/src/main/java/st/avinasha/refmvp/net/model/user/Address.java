package st.avinasha.refmvp.net.model.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public final class Address implements Parcelable {

    @SerializedName("geo") private final Geo geolocation;
    private final String zipcode;
    private final String street;
    private final String suite;
    private final String city;

    public Address(@Nullable Geo geolocation,
                   @Nullable String zipcode,
                   @Nullable String street,
                   @Nullable String suite,
                   @Nullable String city) {
        this.geolocation = geolocation;
        this.zipcode = zipcode;
        this.street = street;
        this.suite = suite;
        this.city = city;
    }

    // region Getter methods.
    public Geo getGeolocation() {
        return geolocation;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
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

        Address address = (Address) o;

        if (getGeolocation() != null ? !getGeolocation().equals(address.getGeolocation())
                : address.getGeolocation() != null) {
            return false;
        }
        if (getZipcode() != null ? !getZipcode().equals(address.getZipcode())
                : address.getZipcode() != null) {
            return false;
        }
        if (getStreet() != null ? !getStreet().equals(address.getStreet())
                : address.getStreet() != null) {
            return false;
        }
        if (getSuite() != null ? !getSuite().equals(address.getSuite())
                : address.getSuite() != null) {
            return false;
        }
        return getCity() != null ? getCity().equals(address.getCity()) : address.getCity() == null;
    }

    @Override
    public int hashCode() {
        int result = getGeolocation() != null ? getGeolocation().hashCode() : 0;
        result = 31 * result + (getZipcode() != null ? getZipcode().hashCode() : 0);
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getSuite() != null ? getSuite().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "geolocation=" + geolocation +
                ", zipcode='" + zipcode + '\'' +
                ", street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    // region Parcelable.
    protected Address(Parcel in) {
        geolocation = in.readParcelable(Geo.class.getClassLoader());
        zipcode = in.readString();
        street = in.readString();
        suite = in.readString();
        city = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(geolocation, flags);
        dest.writeString(zipcode);
        dest.writeString(street);
        dest.writeString(suite);
        dest.writeString(city);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
    // endregion Parcelable.
}
