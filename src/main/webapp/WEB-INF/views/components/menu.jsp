                      <div id="menu">
                        <nav class="navbar">
                          <header>
                            <h3>Menu</h3>
                          </header>
                          <ul>
                            <li class=${(menu.equals("customers") ? "active" : "")}>
                              <i class="fa-solid fa-user"></i>
                              <a href="/customers">Customers</a>
                            </li>
                             <li class=${(menu.equals("products") ? "active" : "")}>
                              <i class="fa-solid fa-shirt"></i>
                              <a href="/products">Products</a>
                            </li>
                            <li class=${(menu.equals("sales") ? "active" : "")}>
                              <i class="fa-solid fa-sack-dollar"></i>
                              <a href="/sales">Sales</a>
                            </li>
                          </ul>
                        </nav>

                        <nav class="navbar">
                          <header>
                            <h3>Manage</h3>
                          </header>
                          <ul>
                            <li class=${(menu.equals("new_customer") ? "active" : "")}>
                              <i class="fa-solid fa-user-plus"></i>
                              <a href="/customers/new">Add Customer</a>
                            </li>
                            <li class=${(menu.equals("new_product") ? "active" : "")}>
                              <i class="fa-solid fa-file-circle-plus"></i>
                              <a href="/products/new">Add Product</a>
                            </li>
                            <li class=${(menu.equals("new_sale") ? "active" : "")}>
                              <i class="fa-solid fa-cart-plus"></i>
                              <a href="/sales/new">Add Sale</a>
                            </li>
                          </ul>
                        </nav>
                      </div>