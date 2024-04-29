<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index Page</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-indigo-500 flex justify-center items-center h-screen">
<div class="flex justify-between">
    <!-- Sign In Box -->
    <div class="w-80 bg-white p-8 rounded-lg shadow-md mb-8 mr-3">
        <h2 class="text-2xl font-semibold mb-4">Sign In</h2>
        <form action="signinServlet" method="POST">
            <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="text-red-500 mb-4"><%= request.getAttribute("errorMessage") %>
            </p>
            <% } %>
            <div class="mb-4">
                <label for="login" class="block mb-1">Username</label>
                <input required type="text" id="login" name="login" class="w-full px-3 py-2 border rounded-md">
            </div>
            <div class="mb-4">
                <label for="password" class="block mb-1">Password</label>
                <input required type="password" id="password" name="password"
                       class="w-full px-3 py-2 border rounded-md">
            </div>
            <button type="submit" class="w-full bg-indigo-600 text-white py-2 rounded-md hover:bg-indigo-700">Sign In
            </button>
        </form>
    </div>

    <!-- Sign Up Box -->
    <div class="w-80 bg-white p-8 rounded-lg shadow-md mb-8 ml-3">
        <h2 class="text-2xl font-semibold mb-4">Sign Up</h2>
        <form action="signupServlet" method="POST">
            <% if (request.getAttribute("emailErrorMessage") != null) { %>
            <p class="text-red-500 mb-4"><%= request.getAttribute("emailErrorMessage") %>
            </p>
            <% } %>
            <div class="mb-4">
                <label for="first_name" class="block mb-1">First Name</label>
                <input required type="text" id="first_name" name="first_name"
                       class="w-full px-3 py-2 border rounded-md">
            </div>
            <div class="mb-4">
                <label for="last_name" class="block mb-1">Last Name</label>
                <input required type="text" id="last_name" name="last_name" class="w-full px-3 py-2 border rounded-md">
            </div>
            <div class="mb-4">
                <label for="signup_login" class="block mb-1">Username</label>
                <input required type="text" id="signup_login" name="signup_login"
                       class="w-full px-3 py-2 border rounded-md">
            </div>
            <div class="mb-4">
                <label for="signup_password" class="block mb-1">Password</label>
                <input required type="password" id="signup_password" name="signup_password"
                       class="w-full px-3 py-2 border rounded-md">
            </div>
            <button type="submit" class="w-full bg-indigo-600 text-white py-2 rounded-md hover:bg-indigo-700">Sign Up
            </button>
        </form>
    </div>
</div>
</body>
</html>

