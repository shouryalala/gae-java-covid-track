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
<!-- [START bookshelf_jsp_base] -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<style>
      html, body{
        height: 100%;
        width:100%;
        /* -webkit-animation-name: fadeIn;
        -webkit-animation-duration: 8s;
        -webkit-animation-timing-function: ease-in-out;
        -webkit-animation-iteration-count: 1;
        -moz-animation-name: fadeIn;
        -moz-animation-duration: 8s;
        -moz-animation-timing-function: ease-in-out;
        -moz-animation-iteration-count: 1; */
        background-color: #ffffff; /* For browsers that do not support gradients */                
        background-image: url("background1.png");
        background-repeat: no-repeat;
        background-size:contain;
        background-position: center;              

        /* opacity: 0; */
      }
</style>

<html lang="en">
  <head>
    <title>Covid Record Tracker</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  </head>
  <body>
    <div class="navbar navbar-default"  style="background-color:#d4b2b2">
      <div class="container">
        <div class="navbar-header">
          <div class="navbar-brand">Covid Record Management System</div>
        </div>    
        <!-- <div class="navbar-brand">
            <label style="text-align:right"> Suraaj Ray Lala</label>
        </div> -->
      </div>
    </div>
    <div style="text-align:center"><a href ="/">Home</a></div>
    <c:import url="/${page}.jsp" />
  </body>
</html>
<!-- [END bookshelf_jsp_base]-->
