package st.avinasha.refmvp.net.model.user;

import android.os.Parcel;
import android.os.Parcelable;

public final class User implements Parcelable {

    private final int id;
    private final String name;
    private final String phone;
    private final String email;
    private final String username;
    private final String website;
    private final Address address;
    private final Company company;

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phone = builder.phone;
        this.email = builder.email;
        this.username = builder.username;
        this.website = builder.website;
        this.address = builder.address;
        this.company = builder.company;
    }

    // region Getter methods.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getWebsite() {
        return website;
    }

    public Address getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }
    // endregion Getter methods.

    // region Parcelabe.
    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        phone = in.readString();
        email = in.readString();
        username = in.readString();
        website = in.readString();
        address = in.readParcelable(Address.class.getClassLoader());
        company = in.readParcelable(Company.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(username);
        dest.writeString(website);
        dest.writeParcelable(address, flags);
        dest.writeParcelable(company, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    // endregion Parcelable.

    public static class Builder {

        private int id;
        private String name;
        private String phone;
        private String email;
        private String username;
        private String website;
        private Address address;
        private Company company;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setCompany(Company company) {
            this.company = company;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
