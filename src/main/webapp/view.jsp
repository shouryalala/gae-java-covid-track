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
<!-- [START bookshelf_jsp_view] -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="container">
  <h3>Record</h3>
  <div class="btn-group">
    <a href="/update?id=${book.id}" class="btn btn-primary btn-sm">
      <i class="glyphicon glyphicon-edit"></i>
      Edit record
    </a>
    <a href="/delete?id=${book.id}" class="btn btn-danger btn-sm">
      <i class="glyphicon glyphicon-trash"></i>
      Delete record
    </a>
  </div>

  <div class="media">
    <!-- <div class="media-left">
      <img class="book-image" src="${fn:escapeXml(not empty book.imageUrl?book.imageUrl:'http://placekitten.com/g/128/192')}">
    </div> -->
    <div class="media-body">
      <h4 class="book-title">
        ${fn:escapeXml(book.name)}
        <small>${fn:escapeXml(book.date)}</small>
      </h4>
      <h5 class="book-author">Age: ${fn:escapeXml(not empty book.age?book.age:'NA')}</h5>
      <p class="book-description">${fn:escapeXml(book.details)}</p>
      <small class="book-added-by">Gender: 
        ${fn:escapeXml(not empty book.gender?(book.gender==1)?'Female':'Male':'NA')}</small>
    </div>
  </div>
</div>
<!-- [END bookshelf_jsp_view] -->
