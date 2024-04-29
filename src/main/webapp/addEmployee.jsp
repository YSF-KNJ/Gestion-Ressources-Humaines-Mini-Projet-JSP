<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
<div class="flex h-screen justify-center items-center">
    <div class="rounded-lg shadow-md p-6 m-3 w-2/3">
        <h1 class="text-2xl font-bold flex justify-center items-center">Add New Employee</h1>
        <form action="addEmployee" method="post">
            <% if (request.getAttribute("error") != null) { %>
            <p class="text-red-500 mb-4"><%= request.getAttribute("error") %>
            </p>
            <% } %>
            <div class="mt-4">
                <label for="prenom" class="block">First Name</label>
                <input type="text" id="prenom" name="prenom" class="w-full px-4 py-2 rounded-md mt-2">
            </div>
            <div class="mt-4">
                <label for="nom" class="block">Last Name</label>
                <input type="text" id="nom" name="nom" class="w-full px-4 py-2 rounded-md mt-2">
            </div>
            <div class="mt-4">
                <label for="email" class="block">Email</label>
                <input type="email" id="email" name="email" class="w-full px-4 py-2 rounded-md mt-2">
            </div>
            <div class="mt-4">
                <label for="telephone" class="block">Telephone</label>
                <input type="text" id="telephone" name="telephone" class="w-full px-4 py-2 rounded-md mt-2">
            </div>
            <div class="mt-4">
                <label for="salaire" class="block">Salary</label>
                <input type="number" id="salaire" name="salaire" class="w-full px-4 py-2 rounded-md mt-2">
            </div>
            <div class="mt-4">
                <label for="id_poste" class="block">Post ID</label>
                <input type="number" id="id_poste" name="id_poste" class="w-full px-4 py-2 rounded-md mt-2">
            </div>
            <div class="mt-4">
                <label for="id_departement" class="block">Department ID</label>
                <input type="number" id="id_departement" name="id_departement" class="w-full px-4 py-2 rounded-md mt-2">
            </div>
            <div class="mt-4 flex justify-center items-center">
                <button type="submit"
                        class="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded-md transition duration-300">
                    Add Employee
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>