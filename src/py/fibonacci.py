def fib(n):
    arr = [0, 1]
    for i in range(2, n + 1):
        arr.append(arr[i - 1] + arr[i - 2])
    return arr[n]


def fib_last_digit(n):
    arr = [0, 1]
    for i in range(2, n + 1):
        arr.append((arr[i - 1] + arr[i - 2]) % 10)
    print(arr)
    return arr[n]


def fib_mod(n, m):
    arr = [0, 1]
    for i in range(2, n + 1):
        arr.append((arr[i - 1] + arr[i - 2]) % m)
        if arr[i - 1] == 1 and arr[i] == 0:
            return arr[n % i]
    return n % m


def main():
    n, m = map(int, input().split())
    print(fib_mod(n, m))


if __name__ == "__main__":
    main()
