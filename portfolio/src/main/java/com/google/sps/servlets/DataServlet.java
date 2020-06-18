// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;


/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("text/html")
public class DataServlet extends HttpServlet {

  ArrayList<String> textBoxMessages= new ArrayList<String>();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //response.setContentType("text/html");

    Query query = new Query("Task").addSort("timestamp", SortDirection.DESCENDING);
    PreparedQuery results = datastore.prepare(query);
    for (Entity entity : results.asIterable()) {

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    PreparedQuery results = datastore.prepare(query);
        
    response.setContentType("application/json;");
  }
  }
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the input from the form.
    String userText = request.getParameter(request, "text-input", "");
    textBoxMessages.add(userText);

    Entity taskEntity = new Entity("Task");
    taskEntity.setProperty("user-comments", userComment);

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    
    response.sendRedirect("/index.html");


    //response.setContentType("text-input");
    //response.getWriter().println(Arrays.toString(words));


    //boolean upperCase = Boolean.parseBoolean(getParameter(request, "upper-case", "false"));
    //boolean sort = Boolean.parseBoolean(getParameter(request, "sort", "false"));
  }
}
