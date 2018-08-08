var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    }
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Melon = /** @class */ (function () {
    function Melon(weight, melonSort) {
        this.weight = weight;
        this.melonSort = melonSort;
        this.elementIndex = weight * melonSort.length;
    }
    Object.defineProperty(Melon.prototype, "getElementIndex", {
        get: function () {
            return this.elementIndex;
        },
        enumerable: true,
        configurable: true
    });
    Melon.prototype.toString = function () {
        return "Element: " + this.elementType + "\nSort: " + this.melonSort + "\nElement Index: " + this.elementIndex;
    };
    return Melon;
}());
var WaterMelon = /** @class */ (function (_super) {
    __extends(WaterMelon, _super);
    function WaterMelon(weight, melonSort) {
        var _this = _super.call(this, weight, melonSort) || this;
        _this.elementType = 'Water';
        return _this;
    }
    return WaterMelon;
}(Melon));
var FireMelon = /** @class */ (function (_super) {
    __extends(FireMelon, _super);
    function FireMelon(weight, melonSort) {
        var _this = _super.call(this, weight, melonSort) || this;
        _this.elementType = 'Fire';
        return _this;
    }
    return FireMelon;
}(Melon));
var EarthMelon = /** @class */ (function (_super) {
    __extends(EarthMelon, _super);
    function EarthMelon(weight, melonSort) {
        var _this = _super.call(this, weight, melonSort) || this;
        _this.elementType = 'Earth';
        return _this;
    }
    return EarthMelon;
}(Melon));
var AirMelon = /** @class */ (function (_super) {
    __extends(AirMelon, _super);
    function AirMelon(weight, melonSort) {
        var _this = _super.call(this, weight, melonSort) || this;
        _this.elementType = 'Air';
        return _this;
    }
    return AirMelon;
}(Melon));
var Melolemonmelon = /** @class */ (function (_super) {
    __extends(Melolemonmelon, _super);
    function Melolemonmelon(weight, melonSort) {
        var _this = _super.call(this, weight, melonSort) || this;
        _this.types = ['Fire', 'Earth', 'Air', 'Water'];
        _this.elementType = 'Water';
        return _this;
    }
    Melolemonmelon.prototype.morph = function () {
        var type = this.types.shift();
        this.elementType = type;
        this.types.push(type);
    };
    return Melolemonmelon;
}(Melon));
//
//let watermelon : WaterMelon = new WaterMelon(12.5, "Kingsize");
//console.log(watermelon.toString());
//
//let firemelon : FireMelon = new FireMelon(15, "KingFire");
//console.log(firemelon.toString());
var melolemonmelon = new Melolemonmelon(15, "KingFire");
console.log(melolemonmelon.toString());
melolemonmelon.morph();
console.log(melolemonmelon.toString());
melolemonmelon.morph();
console.log(melolemonmelon.toString());
melolemonmelon.morph();
console.log(melolemonmelon.toString());
melolemonmelon.morph();
console.log(melolemonmelon.toString());
