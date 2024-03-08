<%-- 
    Document   : nav
    Created on : Mar 2, 2024, 1:37:10 PM
    Author     : Desktop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<nav class="navbar navbar-expand-lg navbar-light bg-dark" style="position: fixed; width: 100% ; top: 0; z-index: 1000">
    <div class="container-fluid">
        <button id="toggleLeftBarBtn" style="height: 100%; "><i class="fas fa-bars"></i></button>
        <div class="collapse navbar-collapse  d-flex justify-content-end " id="navbarSupportedContent">
            
                <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <ul class="navbar-nav  ml-5 mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Category
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Java</a></li>
                        <li><a class="dropdown-item" href="#">C++</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">HTML/CSS</a></li>
                    </ul>
                </li>
                
            </ul>
            

        </div>
    </div>
</nav>
