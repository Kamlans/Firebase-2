package com.example.firebase_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag";
    private List<Model> list;
    private RecyclerView recyclerView;
    private recAdapter adapter;
    ArrayList<Model> arrayList = new ArrayList<>();
    public String firstname , lastname;
    Map<String , String> maplist = new HashMap<>();
    private  String URL;
private Model modellink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

         FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference().child("dp").child("hospital.png");

        Log.d(TAG, "onCreate: "+storageRef.getPath());
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Log.e("Tuts+", "uri: " + uri.toString());
                //Handle whatever you're going to do with the URL here
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onFailure of pic: "+e.getMessage());
            }
        });
//// Add a new document with a generated ID
//        db.collection("users")
//                .add(user)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error adding document", e);
//                    }
//                });
//        // Create a new user with a first, middle, and last name
//        //Map<String, Object> user = new HashMap<>();
//        user.put("first", "Alan");
//        user.put("middle", "Mathison");
//        user.put("last", "Turing");
//        user.put("born", 1912);
//
//// Add a new document with a generated ID
//        db.collection("users")
//                .add(user)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d(TAG, "Error adding document", e);
//                    }
//                });

//        db.collection("users")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d(TAG, document.getId() + " => " + document.getData());
//                            }
//                        } else {
//                            Log.d(TAG, "Error getting documents.", task.getException());
//                        }
//                    }
//                });
//
//        db.collection("users").document("newDoc").set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                Log.d(TAG, "onSuccess: added in newDoc ");
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.d(TAG, "onFailure: failed to add in  new doc");
//            }
//        });
//
//        db.collection("users").document("newDoc").get()
//                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()){
//                    for (QueryDocumentSnapshot document : ) {
//                        Log.d(TAG, document.getId() + " => " + document.getData());
//                    }
//                }
//            }
//        });

//        DocumentReference docRef = db.collection("users").document("newDoc");
//
//        db.collection("users").document("newDoc")
//                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
//                        String first = document.get("first").toString();
//                        String last = document.get("last").toString();
//
//                        Log.d(TAG, "onComplete: "+first+last);
//                        list.add(new Model( first ,last));
//
//                        Log.d(TAG, "onComplete: ");
//
////                        list.add(new Model(first , last));
////                        Log.d(TAG, "DocumentSnapshot data: " + list.toString());
//                    } else {
//                        Log.d(TAG, "No such document");
//                    }
//                } else {
//                    Log.d(TAG, "get failed with ", task.getException());
//                }
//            }
//        });
//
//
//        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//
//
////                Log.d(TAG, "onSuccess: "+documentSnapshot.getString("last"));
////                Model model = documentSnapshot.toObject(Model.class);
////                assert model != null;
////                Log.d(TAG, "onSuccess: " +model.getFf() +model.getSf());
////                Log.d(TAG, "onSuccess: " + model);
//
//                list.add(new Model(documentSnapshot.get("first").toString() , documentSnapshot.get("last").toString()));
//
//                Log.d(TAG, "onSuccess: ");
//                Log.d(TAG, "onSuccess: " + list.toString());
//            }
//        });

        String x = "x" , y = " y";

        recyclerView = findViewById(R.id.recView);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
       // recyclerView.setAdapter( new recAdapter(MainActivity.this, arrayList));

        arrayList.add( new Model("kamlans" ,"Jugal"));

        arrayList.add( new Model(x , y));
        arrayList.add( new Model(firstname , lastname));
        db.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (DocumentSnapshot d : task.getResult()){
                    Model model = new Model(d.getString("first") , d.getString("last"));
                    Model line = new Model("-----------" , "---------");
                    Model objModel = d.toObject(Model.class);
                    arrayList.add(line);
                    arrayList.add(model);

                    storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Log.e("Tuts+", "uri: " + uri.toString());
                            //Handle whatever you're going to do with the URL here
                            Intent intent = new Intent(MainActivity.this , MainActivity.class);
                            intent.putExtra("url" , uri.toString());
                            Log.d(TAG, "onSuccess: "+arrayList.toString());
                            URL = uri.toString();
                            Log.d("petu", "onComplete: with url"+URL);

                             modellink = new Model(d.getString("first") , URL);

                            Log.d( "qwerty", "onSuccess: with link "+modellink.getFf()+ "    " +modellink.getSf());
                            try{
                                arrayList.add(modellink);
                                Log.d("qwerty", "onSuccess: ");
                                Log.d("mom", "onCreate: "+ arrayList.get(2).getSf());

                            }catch (Exception exception){
                                Log.d("qwerty", "exception: "+ exception.getMessage());
                            }


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure of pic: "+e.getMessage());
                        }
                    });


                    //Log.d("qwerty", "onComplete: "+ "    "+arrayList.size()+ "      "+modellink.getFf() + "    " +modellink.getSf() );


                    String newString;
                    if (savedInstanceState == null) {
                        Bundle extras = getIntent().getExtras();
                        if(extras == null) {
                            newString= null;
                        } else {
                            newString= extras.getString("url");
                        }
                    } else {
                        newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
                    }

                    Log.d("petu", "onComplete: "+newString);
                    Log.d("petu", "onComplete: "+URL);
                    Log.d("petu", "onComplete: ");

                }

                adapter = new recAdapter(arrayList);
                recyclerView.setAdapter(adapter);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onFailure: "+e.getMessage());
            }
        });



//        Log.d(TAG, "onCreate: "+maplist.toString());
//        Log.d(TAG, "onCreate: "+arrayList.toString());

        for (int i = 0; i <arrayList.size(); i++) {
//            Log.d("mom", "onCreate: "+ arrayList.get(i).getSf());
//            Log.d("mom", "onCreate: "+ arrayList.size());
            Log.d("mom", "onCreate: "+ arrayList.get(2).getSf());

        }
    }
}