package edu.ncc.nest.nestapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class GuestFormHelper extends SQLiteOpenHelper {


    // The URI scheme used for content URIs
    public static final String SCHEME = "content";

    // The provider's authority
    public static final String AUTHORITY = "edu.ncc.zqk.nestguestforms";

    public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

    // table name
    public static final String TABLE_NAME = "NESTGuestForm";

    // columns in the table
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String DATE = "date";
    public static final String ADDRESS = "address";
    public static final String CITY = "city";
    public static final String ZIP = "zipcode";
    public static final String STATE = "state";
    public static final String ADDITIONALINFO = "addInfo";
    public static final String NAMEOFVOLUNTEER = "nameOfVolunteer";

    public static final String NCCID = "nccID";

    public static final String LOCATION = "location";

    public boolean insertData(String name, String email, String phone, String date, String address, String city, String zip) {

        //creating an SQLLite database
        SQLiteDatabase db1 = this.getWritableDatabase();

        //All info for a single user will be placed into the same ContentValue variable
        ContentValues cValues = new ContentValues();

        //loading user information into the content value
        cValues.put(NAME, name);
        cValues.put(EMAIL, email);
        cValues.put(PHONE, phone);
        cValues.put(DATE, date);
        cValues.put(ADDRESS, address);
        cValues.put(CITY, city);
        cValues.put(ZIP, zip);
        // leaving out for now: cValues.put(STATE, state);

        //placing the information into the database
        long res = db1.insert(TABLE_NAME, null, cValues);

        //insert method will return a negative 1 if there was an error with the insert
        if (res == -1) {
            return false;
        }

        //returning true if insertion was successful
        return true;

    }


    // database version and name
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "GuestFormInformation.db";

    public GuestFormHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + _ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME +
                " TEXT, " + EMAIL + " TEXT, " + DATE + "TEXT, " + ADDRESS + "TEXT, " +
                CITY + "TEXT, " + ZIP + "TEXT, " + STATE + "TEXT, " + ADDITIONALINFO + "TEXT, " + NAMEOFVOLUNTEER + "TEXT, " +
                NCCID + "TEXT, " + PHONE + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
