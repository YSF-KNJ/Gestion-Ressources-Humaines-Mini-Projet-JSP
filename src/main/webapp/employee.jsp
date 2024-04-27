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
    <div id="sidebar" class="w-64 bg-indigo-600 text-white flex flex-col justify-between">
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
            <a href="#">
                <li class="px-4 py-3 flex items-center justify-start space-x-4 hover:text-indigo-300">
                    <img src="resources/Posts.png" alt="Posts" class="h-8 w-auto">
                    <span class="text-lg">Posts</span>
                </li>
            </a>
            <a href="#">
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
            <button class="bg-yellow-400 hover:bg-yellow-500 text-white px-4 py-2 w-full rounded-md transition duration-300 hidden">Logout</button>
        </div>
    </div>

    <div id="content" class="flex-1 p-8">
        <h1 class="text-2xl font-bold">Departments Management</h1>
    </div>
</div>
</body>
</html>
