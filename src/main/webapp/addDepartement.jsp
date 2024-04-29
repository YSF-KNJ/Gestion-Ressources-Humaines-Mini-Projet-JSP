<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Department</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
<div class="flex h-screen justify-center items-center">
    <div class="rounded-lg shadow-md p-6 m-3 w-2/3">
        <h1 class="text-2xl font-bold flex justify-center items-center">Add New Department</h1>
        <form action="addDepartment" method="post">
            <div class="mt-4">
                <label for="nom_departement" class="block">Department Name</label>
                <input type="text" id="nom_departement" name="nom_departement" class="w-full px-4 py-2 rounded-md mt-2">
            </div>
            <div class="mt-4">
                <label for="id_localisation" class="block">Location ID</label>
                <input type="number" id="id_localisation" name="id_localisation" class="w-full px-4 py-2 rounded-md mt-2">
            </div>
            <div class="mt-4">
                <label for="id_admin" class="block">Admin ID</label>
                <input type="number" id="id_admin" name="id_admin" class="w-full px-4 py-2 rounded-md mt-2">
            </div>
            <div class="mt-4 flex justify-center items-center">
                <button type="submit" class="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded-md transition duration-300">
                    Add Department
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>