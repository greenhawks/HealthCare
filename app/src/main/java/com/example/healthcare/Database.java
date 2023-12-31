package com.example.healthcare;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class Database extends SQLiteOpenHelper{
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table if not exists users(username text, email text, password text)";
        String query1 = "create table if not exists cart(username text, product text, price float, otype text)";
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(query1);
    }

    public void register(String username , String email , String Password)
    {
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",Password);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }
    public boolean check(String user , String pass)
    {
        String query = "select count(*) from users where username = ? and password = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        try(Cursor c = db.rawQuery(query,new String[]{user,pass})){
            if(c.moveToFirst())
            {
                int s = c.getInt(0);
                return s>0;
            }
        }
        catch(Exception e)
        {
            e.fillInStackTrace();
        }
        finally {
            db.close();
        }
    return false;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            onCreate(sqLiteDatabase);
    }
    public void addToCart(String username, String product, String price, String type) {
        SQLiteDatabase db = getWritableDatabase();

        try {
            float priceValue = 0.0f;

            // Check if price is not null and parse it
            if (price != null && !price.isEmpty()) {
                priceValue = Float.parseFloat(price);
                Log.d("Database", "Parsed Price: " + priceValue);
            } else {
                Log.e("Database", "Invalid or null price provided.");
                return; // Stop processing if price is invalid
            }

            // Check if the product is already in the cart for the given user
            Cursor cursor = db.rawQuery("SELECT * FROM cart WHERE username = ? AND product = ? AND otype = ?",
                    new String[]{username, product, type});

            try {
                if (cursor.getCount() > 0) {
                    // Product already exists in the cart, you may want to update quantity or handle it as needed
                    // For now, let's just log a message
                    Log.d("Database", "Product already in the cart for user: " + username);
                } else {
                    // Product is not in the cart, add it
                    ContentValues cv = new ContentValues();
                    cv.put("username", username);
                    cv.put("product", product);
                    cv.put("price", priceValue);
                    cv.put("otype", type);
                    db.insert("cart", null, cv);

                    // Log a message indicating successful addition
                    Log.d("Database", "Product added to cart for user: " + username);
                }
            } finally {
                cursor.close();
            }
        } catch (NumberFormatException e) {
            // Handle the case where parsing the price fails
            Log.e("Database", "Error parsing price: " + price);
        } finally {
            db.close();
        }
    }


    public ArrayList<String> getData(String username ,String otype) {
        ArrayList<String> a = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String[] s = new String[2];
        s[0]=username;
        s[1]=otype;
        Cursor cursor = sqLiteDatabase.rawQuery("select * from cart where username = ?and otype = ?", s);

        try {
            if (cursor.moveToFirst()) {
                do {
                    String q1 = cursor.getString(1);
                    float q2 = cursor.getFloat(2);
                    String data = q1 + "$" + Float.toString(q2);
                    a.add(data);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
            sqLiteDatabase.close();
        }

        return a;
    }




}
