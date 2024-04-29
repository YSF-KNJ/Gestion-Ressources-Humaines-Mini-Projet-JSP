<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employees Management</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
<div class="flex h-screen">

    <div id="sidebar"
         class="w-64 bg-indigo-600 text-white flex flex-col justify-between fixed top-0 bottom-0 overflow-y-auto">
        <div class="flex items-center justify-center p-4">
            <img src="resources/management.png" alt="Logo" class="h-12 w-auto">
        </div>
        <ul class="flex-1">
            <a href="employees">
                <li class="px-4 py-3 flex items-center justify-start space-x-4 text-indigo-300">
                    <img src="resources/Employees.png" alt="Employees" class="h-8 w-auto">
                    <span class="text-lg">Employees</span>
                </li>
            </a>
            <a href="postes">
                <li class="px-4 py-3 flex items-center justify-start space-x-4 hover:text-indigo-300">
                    <img src="resources/Posts.png" alt="Posts" class="h-8 w-auto">
                    <span class="text-lg">Posts</span>
                </li>
            </a>
            <a href="localisations">
                <li class="px-4 py-3 flex items-center justify-start space-x-4 hover:text-indigo-300">
                    <img src="resources/Localisation.png" alt="Localisations" class="h-8 w-auto">
                    <span class="text-lg">Localisations</span>
                </li>
            </a>
            <a href="departements">
                <li class="px-4 py-3 flex items-center justify-start space-x-4 hover:text-indigo-300">
                    <img src="resources/Departments.png" alt="Departments" class="h-8 w-auto">
                    <span class="text-lg">Departments</span>
                </li>
            </a>
        </ul>

        <div class="p-4">
            <form action="logoutServlet" method="POST">
                <button type="submit"
                        class="bg-yellow-400 hover:bg-yellow-500 text-white px-4 py-2 w-full rounded-md flex items-center justify-center transition duration-300">
                    <img src="resources/logout.png" alt="Logout" class="h-6 w-auto mr-2">
                    <span>Logout</span>
                </button>
            </form>
        </div>

    </div>


    <div id="content" class="flex-1 p-8 ml-64">
        <h1 class="text-2xl font-bold flex justify-center items-center">Employees Management</h1>

        <div class="flex justify-center items-center">
            <div class="rounded-lg shadow-md p-6 m-3 w-2/3">
                <div class="flex justify-center items-center">
                    <button class="inline-block m-3 p-2 bg-green-500 hover:bg-green-600 text-white px-6 py-3 rounded-md transition duration-300">
                        <a href="addEmployee" class="text-white">Add Employee</a>
                    </button>
                    <button class="inline-block m-3 p-2 bg-yellow-500 hover:bg-yellow-600 text-white px-6 py-3 rounded-md transition duration-300">
                        <a href="importEmployees" class="text-white">Import Employees</a>
                    </button>
                </div>
            </div>
        </div>


        <%
            List<String[]> employees = (List<String[]>) request.getAttribute("employees");
            for (String[] employee : employees) {
        %>

        <div class="mt-8">
            <div class="bg-white rounded-lg shadow-md p-6 mb-4 flex justify-between items-center">
                <div>
                    <h2 class="text-lg font-semibold">Employee ID: <%= employee[0] %></h2>
                    <p class="text-gray-600">First Name: <%= employee[1] %></p>
                    <p class="text-gray-600">Last Name: <%= employee[2] %></p>
                    <p class="text-gray-600">Email: <%= employee[3] %></p>
                    <p class="text-gray-600">Phone: <%= employee[4] %></p>
                    <p class="text-gray-600">Salary: <%= employee[5] %></p>
                    <p class="text-gray-600">Post ID: <%= employee[6] %></p>
                    <p class="text-gray-600">Department ID: <%= employee[7] %></p>
                </div>

                <div class="flex items-center">
                    <form class="inline-block" action="deleteEmployee" method="post"
                          onsubmit="return confirm('Are you sure you want to delete this employee?');">
                        <input type="hidden" name="employeeId" value="<%= employee[0] %>">
                        <button type="submit"
                                class="bg-red-500 hover:bg-red-600 text-white px-3 py-1 rounded-md transition duration-300">
                            Delete
                        </button>
                    </form>
                    <form class="inline-block ml-2" action="editEmployee" method="post">
                        <input type="hidden" name="employeeId" value="<%= employee[0] %>">
                        <button type="submit"
                                class="bg-blue-500 hover:bg-blue-600 text-white px-3 py-1 rounded-md transition duration-300">
                            Edit
                        </button>
                    </form>
                </div>

            </div>
        </div>


        <% } %>

    </div>
</div>
</body>
</html>