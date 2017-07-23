package st.avinasha.refmvp.net.model.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public final class Company implements Parcelable {

    private final String catchPhrase;
    private final String name;
    @SerializedName("bs") private final String description;

    public Company(@Nullable String catchPhrase,
                   @Nullable String name,
                   @Nullable String description) {
        this.catchPhrase = catchPhrase;
        this.name = name;
        this.description = description;
    }

    // region Getter methods.
    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

        Company company = (Company) o;

        if (getCatchPhrase() != null ? !getCatchPhrase().equals(company.getCatchPhrase())
                : company.getCatchPhrase() != null) {
            return false;
        }
        if (getName() != null ? !getName().equals(company.getName()) : company.getName() != null) {
            return false;
        }
        return getDescription() != null ? getDescription().equals(company.getDescription())
                : company.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getCatchPhrase() != null ? getCatchPhrase().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "catchPhrase='" + catchPhrase + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    // region Parcelable.
    protected Company(Parcel in) {
        catchPhrase = in.readString();
        name = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(catchPhrase);
        dest.writeString(name);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };
    // endregion Parcelable.
}
