from abc import ABC, abstractmethod


class Jsonify(ABC):
    @abstractmethod
    def to_json(self):
        pass
