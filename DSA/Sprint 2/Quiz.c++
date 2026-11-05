/*#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<int> a = {1, 2, 2, 4, 5};
    int n = a.size();

    vector<int> freq(n + 1, 0);

    int missing = -1;
    int repeated = -1;

    for (int x : a)
    {
        ++freq[x];
    }

    for (int v = 1; v <= n; ++v)
    {
        if (freq[v] == 0)
        {
            missing = v;
        }

        if (freq[v] == 2)
        {
            repeated = v;
        }
    }

    cout << "Missing number: " << missing << '\n';
    cout << "Repeated number: " << repeated << '\n';

    return 0;
} */

#include <iostream>
#include <vector>
using namespace std;

class Base
{
protected:
    int value = 7;
};
class Derived : public Base
{
public:
    int get() const { return value; }
};
int main()
{
    Derived d;
    cout << d.get();
}