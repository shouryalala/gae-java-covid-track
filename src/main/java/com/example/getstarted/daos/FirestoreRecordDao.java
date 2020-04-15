package com.example.getstarted.daos;

import com.example.getstarted.objects.*;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class FirestoreRecordDao implements RecordDao {
  private CollectionReference recordsCollection;

  public FirestoreRecordDao() {
    Firestore firestore = FirestoreOptions.getDefaultInstance().getService();
    recordsCollection = firestore.collection("records");
  }


  private Record documentToRecord(DocumentSnapshot document) {
    Map<String, Object> data = document.getData();
    if (data == null) {
      System.out.println("No data in document " + document.getId());
      return null;
    }

    String date = (String)data.get(Record.DATE);
    String name = (String)data.get(Record.NAME);
    Long age = (Long)data.get(Record.AGE);
    Long gender = (Long)data.get(Record.GENDER);
    String details = (String)data.get(Record.DETAILS);    
    String id = document.getId();
    String url = (String)data.get(Record.IMAGE_URL);
    String symptoms = (String)data.get(Record.SYMPTOMS);
    Long status = (Long)data.get(Record.STATUS);
    Integer genderVal = 0;
    if(gender!=null){
        genderVal = gender.intValue();
        genderVal = (genderVal>1)?0:genderVal;
    }

    return new Record(
      date,name,(age!=null)?age.intValue():55,genderVal,details,id,
      url,symptoms,(status!=null)?status.intValue():1);
  }

  @Override
  public String createRecord(Record record) {
    String id = UUID.randomUUID().toString();
    DocumentReference document = recordsCollection.document(id);
    Map<String, Object> data = Maps.newHashMap();

    data.put(Record.DATE, record.getDate());
    data.put(Record.NAME, record.getName());
    data.put(Record.AGE, record.getAge());
    data.put(Record.GENDER, record.getGender());
    data.put(Record.DETAILS, record.getDetails());
    data.put(Record.SYMPTOMS, record.toSymptoms());
    data.put(Record.GENDER, record.getGender());
    data.put(Record.IMAGE_URL, record.getImageUrl());
    data.put(Record.STATUS, record.getStatus());
    try {
      document.set(data).get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    return id;
  }
  // [END bookshelf_firestore_create_book]

  // [START bookshelf_firestore_read]
  @Override
  public Record readRecord(String recordId) {
    try {
      DocumentSnapshot document = recordsCollection.document(recordId).get().get();

      return documentToRecord(document);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return null;
  }
  // [END bookshelf_firestore_read]

  // [START bookshelf_firestore_update]
  @Override
  public void updateRecord(Record record) {
    DocumentReference document = recordsCollection.document(record.getId());
    Map<String, Object> data = Maps.newHashMap();
    
    data.put(Record.DATE, record.getDate());
    data.put(Record.NAME, record.getName());
    data.put(Record.AGE, record.getAge());
    data.put(Record.GENDER, record.getGender());
    data.put(Record.DETAILS, record.getDetails());
    data.put(Record.SYMPTOMS, record.toSymptoms());
    data.put(Record.GENDER, record.getGender());
    data.put(Record.IMAGE_URL, record.getImageUrl());
    data.put(Record.STATUS, record.getStatus());
    try {
      document.set(data).get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
  // [END bookshelf_firestore_update]

  // [START bookshelf_firestore_delete]
  @Override
  public void deleteRecord(String recordId) {
    try {
      recordsCollection.document(recordId).delete().get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
  // [END bookshelf_firestore_delete]

  // [START bookshelf_firestore_documents_to_books]
  private List<Record> documentsToRecords(List<QueryDocumentSnapshot> documents) {
    List<Record> resultRecords = new ArrayList<>();
    for (QueryDocumentSnapshot snapshot : documents) {
      resultRecords.add(documentToRecord(snapshot));
    }
    return resultRecords;
  }
  // [END bookshelf_firestore_documents_to_books]

  // [START bookshelf_firestore_list_books]
  @Override
  public Result<Record> listRecords(String startTitle) {
    Query recordsQuery = recordsCollection.orderBy("name").limit(10);
    if (startTitle != null) {
      recordsQuery = recordsQuery.startAfter(startTitle);
    }
    try {
      QuerySnapshot snapshot = recordsQuery.get().get();
      List<Record> results = documentsToRecords(snapshot.getDocuments());
      String newCursor = null;
      if (results.size() > 0) {
        newCursor = results.get(results.size() - 1).getName();
      }
      return new Result<>(results, newCursor);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return new Result<>(Lists.newArrayList(), null);
  }
  // [END bookshelf_firestore_list_books]

  // [START bookshelf_firestore_list_by_user]
  @Override
  public Result<Record> listRecordsByStatus(Integer status, String startTitle) {
    Query recordsQuery =
        recordsCollection.orderBy("name").whereEqualTo(Record.STATUS, status).limit(10);
    // if (startTitle != null) {
    //   booksQuery = booksQuery.startAfter(startTitle);
    // }
    try {
      QuerySnapshot snapshot = recordsQuery.get().get();
      List<Record> results = documentsToRecords(snapshot.getDocuments());
      String newCursor = null;
      if (results.size() > 0) {
        newCursor = results.get(results.size() - 1).getName();
      }
      return new Result<>(results, newCursor);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return new Result<>(Lists.newArrayList(), null);
  }
}

