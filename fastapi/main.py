from fastapi import FastAPI, Path, HTTPException, Query
from typing import Optional, Dict
from models import Item, UpdateItem, DeleteResponse  # Import from models.py

app = FastAPI()

inventory: Dict[int, Item] = {1: Item(name="Milk", price=2.99, brand="Amul")}


@app.get("/")
def home():
    return {"Data": "Testing"}


@app.get("/get-item/{item_id}")
def get_item(
    item_id: int = Path(
        description="The ID of the item you'd like to view",
        gt=0,
    )
):
    if item_id not in inventory:
        raise HTTPException(status_code=404, detail="Item ID not found")
    return inventory[item_id]


@app.get("/get-by-name/{item_id}")
def get_by_name(*, item_id: int, name: Optional[str] = None, test: int):
    for item_id in inventory:
        if inventory[item_id].name == name:
            return inventory[item_id]
    return {"Data": "Not found"}


@app.post("/create-item/{item_id}")
def create_item(item_id: int, item: Item):
    if item_id in inventory:
        raise HTTPException(status_code=400, detail="Item ID already exists")
    inventory[item_id] = item
    return inventory[item_id]


@app.put("/update-item/{item_id}")
def update_item(item_id: int, item: UpdateItem):
    if item_id not in inventory:
        raise HTTPException(status_code=404, detail="Item ID does not exist")

    existing_item_data = inventory[item_id].dict()
    updated_fields = item.dict(exclude_unset=True)
    existing_item_data.update(updated_fields)

    inventory[item_id] = Item(**existing_item_data)
    return inventory[item_id]


@app.delete("/delete-item")
def delete_item(
    item_id: int = Query(..., description="The ID of the item to delete", gt=0)
):
    if item_id not in inventory:
        raise HTTPException(status_code=404, detail="Item ID does not exist")

    del inventory[item_id]

    response = DeleteResponse(item_id=item_id)
    return response.to_response(status_code=200)
