package com.show.series.httpnetwork.activity.first;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.show.series.httpnetwork.R;

import butterknife.BindView;

/**
 * Created by lihf on 16/7/19.
 */
public class FirstSqliteActivity extends Activity {


    @BindView(R.id.create)
    Button createData;

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_sq_act);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
    }


    public void CreateData(View view) {
        dbHelper.getWritableDatabase();  //用于创建和升级数据库
    }

    public void AddData(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "the first line code");
        values.put("pages", 345);
        values.put("price", 14.99);
        values.put("author", "guolin");
        db.insert("Book", null, values);

        values.clear();

        values.put("name", "android elite");
        values.put("pages", 666);
        values.put("price", 16.2);
        values.put("author", "xuyisheng");
        db.insert("Book", null, values);
    }

    public void UpdateData(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("price", 29.00);
        db.update("Book", values, "name = ?", new String[]{"the first line code"});
    }


    public void DeleteData(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("Book", "pages>?", new String[]{"300"});
    }


    public void QueryData(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //查询book中所有的数据
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                //遍历cursor对象
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));

                Log.e("name", name);
                Log.e("author", author);
                Log.e("pages", pages + "");
                Log.e("price", price + "");

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

    }


}
