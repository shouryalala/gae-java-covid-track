<!--
Copyright 2019 Google LLC

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
-->
<!-- [START bookshelf_jsp_form] -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="container">
  <h3>
    <c:out value="${action}" /> Record
  </h3>

  <form method="POST" action="${destination}" enctype="multipart/form-data">

    <div class="form-group">
      <label for="name">Name</label>
      <input type="text" name="name" id="name" value="${fn:escapeXml(book.name)}" class="form-control" />
    </div>

    <div class="form-group">
      <label for="age">Age</label>
      <input type="text" name="age" id="age" value="${fn:escapeXml(book.age)}" class="form-control" />
    </div>

    <div class="form-group">
      <label for="date">Date</label>
      <input type="text" name="date" id="date" value="${fn:escapeXml(book.date)}" class="form-control" />
    </div>

    <div class="form-group">
      <label for="details">Details</label>
      <textarea name="details" id="details" class="form-control">${fn:escapeXml(book.details)}</textarea>
    </div>  

    <div class="form-group">
      <label for="gender">Gender</label>
      <label><input type="radio" name="gender" id="gender" value="male" checked/>Male</label>  
      <label><input type="radio" name="gender" id="gender" value="female"/>Female</label>
    </div>  


    <div class="form-group">
      <label for="symptoms">Symptoms: </label>&nbsp;&nbsp;&nbsp;
      <input type = "checkbox" name = "SA" checked = "checked" /> Cough&nbsp;
      <input type = "checkbox" name = "SB" /> Fever&nbsp;
      <input type = "checkbox" name = "SC" /> Body Ache&nbsp;
      <input type = "checkbox" name = "SD" /> Breathlessness&nbsp;
      <!-- <label><input type="radio" name="symptomsA" id="symptomsA" value="A"/>Cough</label>  
      <label><input type="radio" name="symptomsB" id="symptomsB" value="B"/>Fever</label>
      <label><input type="radio" name="symptomsC" id="symptomsC" value="C"/>Body Ache</label>
      <label><input type="radio" name="symptomsD" id="symptomsD" value="D"/>Breathlessness</label>      -->
    </div>  


    <div class="form-group">
      <label for="status">Current Status:</label>&nbsp;&nbsp;
      <label><input type="radio" name="status" id="status" value="recovered" checked/>Recovered</label>  &nbsp;
      <label><input type="radio" name="status" id="status" value="admitted" checked/>Admitted</label>  &nbsp;
      <label><input type="radio" name="status" id="status" value="deceased"/>Deceased</label>&nbsp;
    </div>  

    <div class="form-group ${isCloudStorageConfigured ? '' : 'hidden'}">
      <label for="image">Cover Image</label>
      <input type="file" name="file" id="file" class="form-control" />
    </div>

    <div class="form-group hidden">
      <label for="imageUrl">Prescription URL</label>
      <input type="hidden" name="id" value="${book.id}" />
      <input type="text" name="imageUrl" id="imageUrl" value="${fn:escapeXml(book.imageUrl)}" class="form-control" />
    </div>

    <button type="submit" class="btn btn-success">Save</button>
  </form>
</div>
<!-- [END bookshelf_jsp_form] -->
