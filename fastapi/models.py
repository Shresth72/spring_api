from pydantic import BaseModel
from typing import Optional


class Item(BaseModel):
    name: str
    price: float
    brand: Optional[str] = None


class UpdateItem(BaseModel):
    name: Optional[str] = None
    price: Optional[float] = None
    brand: Optional[str] = None


class DeleteResponse(BaseModel):
    message: str = "Item successfully deleted"
    item_id: int

    def __init__(self, item_id: int):
        super().__init__(item_id=item_id)

    @classmethod
    def from_data(cls, item_id: int) -> "DeleteResponse":
        return cls(message="Item successfully deleted", item_id=item_id)

    def to_response(self, status_code: int = 200):
        from fastapi.responses import JSONResponse

        return JSONResponse(content=self.dict(), status_code=status_code)
