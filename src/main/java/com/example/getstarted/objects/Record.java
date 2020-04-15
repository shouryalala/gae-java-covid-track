/* Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.getstarted.objects;

import java.util.*; 

public class Record {
  private String date;
  private String name;
  private Integer age;
  private Integer gender;  
  private String details;
  private String id;
  private String imageUrl;
  private String symptoms;
  private Integer status;  
  public static final String DATE = "date";
  public static final String NAME = "name";
  public static final String AGE = "age";
  public static final String GENDER = "gender";
  public static final String ID = "id";
  public static final String DETAILS = "details";
  public static final String SYMPTOMS = "symptoms";
  public static final String IMAGE_URL = "imageUrl";
  public static final String STATUS = "status";
  public Set<String> symptomsDecoded;
  public static final String SYMPTOM_COUGH = "C";
  public static final String SYMPTOM_FEVER = "F";
  public static final String SYMPTOM_BODYACHE = "A";
  public static final String SYMPTOM_BREATHLESSNESS = "B";
  public static final String FEVER = "Fever";
  public static final String COUGH = "Cough";
  public static final String BODYACHE = "Body-Ache";
  public static final String BREATHLESSNESS = "Breathlessness";

  public static final Integer STATUS_CODE_RECOVERED = 0;
  public static final Integer STATUS_CODE_ADMITTED = 1;
  public static final Integer STATUS_CODE_DECEASED = 2;




  public Record(String date, String name, Integer age, Integer gender, String details,
             String id, String imageUrl, String symptoms, Integer status) {
      this.date = date;
      this.name = name;
      this.age = age;
      this.gender = gender;
      this.details = details;
      this.id = id;
      this.imageUrl = imageUrl;
      this.symptoms = symptoms;
      this.status = status;

      symptomsDecoded = new HashSet<>();
      if(symptoms != null && !symptoms.isEmpty()) {
        if(symptoms.contains(SYMPTOM_FEVER))symptomsDecoded.add(FEVER);
        if(symptoms.contains(SYMPTOM_COUGH))symptomsDecoded.add(COUGH);
        if(symptoms.contains(SYMPTOM_BODYACHE))symptomsDecoded.add(BODYACHE);
        if(symptoms.contains(SYMPTOM_BREATHLESSNESS))symptomsDecoded.add(BREATHLESSNESS);
      }      
  }

  
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSymptoms() {
		return this.symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

    public String decodeGender() {
        return (this.gender==0)?"Male":"Female";
    }

    public String decodeStatus() {
        if(this.status == null) return "NA";
        else if(this.status == 0) return "Recovered";
        else if(this.status == 1) return "Admitted";
        else return "Deceased";
    }

    public String decodeSymptoms() {
        String res = " ";
        if(this.symptomsDecoded != null && !this.symptomsDecoded.isEmpty()) {
            for(String sy: symptomsDecoded) {
                res = res.concat(sy + " ");
            }
        }else{
            res = res.concat("NA");
        }
        return res;
    }

    public String toSymptoms() {
        String res = "";
        if(symptomsDecoded != null && symptomsDecoded.size()>0) {
            for(String x: symptomsDecoded) {
                switch(x) {
                    case FEVER: res = res.concat(SYMPTOM_FEVER);break;
                    case COUGH: res = res.concat(SYMPTOM_COUGH);break;
                    case BODYACHE: res = res.concat(SYMPTOM_BODYACHE);break;
                    case BREATHLESSNESS: res = res.concat(SYMPTOM_BREATHLESSNESS);break;
                    default: res = res.concat(SYMPTOM_COUGH);
                }                
            }
        }
        return res;
    }
}

